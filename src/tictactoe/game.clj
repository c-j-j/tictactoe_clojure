(ns tictactoe.game)
(use '[tictactoe.board])

(declare play-game)
(declare play-turn)
(declare get-move)
(declare parse-int)
(declare game-over?)

(defn play-game[board print-board]
  (loop [current-board board]
      (print-board current-board)
      (if (game-over? current-board)
        current-board
        (recur (play-turn current-board)))
    )
  )

(defn play-turn [board]
  (add-move board (get-move)))

(defn game-over? [board]
  (or (won? board) (draw? board)))

(defn- get-move[]
  (parse-int (read-line)))

(defn parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)) )
