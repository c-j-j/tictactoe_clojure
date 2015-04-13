(ns tictactoe.main)
(use '[tictactoe.board])
(use '[tictactoe.game])
(use '[tictactoe.display])

(defn -main []
  (play-game (new-board) print-board))
