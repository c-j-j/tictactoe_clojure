(ns tictactoe.main)
(use '[tictactoe.board])
(use '[tictactoe.game])
(use '[tictactoe.display])
(use '[tictactoe.humanplayer])

(defn -main []
  (play-game (new-board) print-board get-move))
