(ns tictactoe.game)
(use '[tictactoe.board])

(defn game-over? [board]
  (or (won? board) (draw? board)))

(defn play-turn [board player-move]
  (add-move board (player-move board))
)

(defn play-game[board display-output player-move]
  (loop [current-board board]
      (display-output current-board)
      (if (game-over? current-board)
        current-board
        (recur (play-turn current-board player-move)))))


