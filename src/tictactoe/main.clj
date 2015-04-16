(ns tictactoe.main)
(use '[tictactoe.board])
(use '[tictactoe.game])
(use '[tictactoe.display])
(use '[tictactoe.humanplayer])
(use '[tictactoe.player])

(defn -main []
  (play-game (new-board) display-output (player-move {:player_type :human})))
