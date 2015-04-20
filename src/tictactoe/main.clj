(ns tictactoe.main)
(use '[tictactoe.board])
(use '[tictactoe.game])
(use '[tictactoe.display])
(use '[tictactoe.humanplayer])
(use '[tictactoe.computerplayer])
(use '[tictactoe.player])
(use '[tictactoe.game-setup])

(defn -main []
  (let [board (setup-board get-option-from-user)
       players (setup-players get-option-from-user)]
  (play-game board display-output players)))
