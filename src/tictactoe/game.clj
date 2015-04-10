(ns tictactoe.game)
(use '[tictactoe.board])

(declare get-move)
(declare parse-int)
(declare game-over?)

(defn play-game[board]
  (loop [current-board board]
    (println current-board)
    ;; print board here
      (if (game-over? current-board)
        current-board
        (recur (play current-board)))
    )
  )

(defn play [board]
  (add-move board (get-move)))

(defn game-over? [board]
  (won? board)
  )

(defn- get-move[]
  (parse-int (read-line)))

(defn parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)) )
