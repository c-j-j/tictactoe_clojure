(ns tictactoe.game
  (require [tictactoe.player :as player]))
(use '[tictactoe.board])

(defn game-over? [board]
  (or (won? board) (draw? board)))

(defn play-turn [board [player1 player2]]
  (let [get-move-from-player #(player/get-move-new % board)]
    (add-move board (if (player-ones-turn? board)
                   (get-move-from-player player1)
                   (get-move-from-player player2)
                    ))))

(defn get-score[board]
  (cond
    (won? board) -10
    (draw? board) 0))

(defn play-game[board display-output players]
  (loop [current-board board]
    (display-output current-board)
    (if (game-over? current-board)
      current-board
      (recur (play-turn current-board players)))))
