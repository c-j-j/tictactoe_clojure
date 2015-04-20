(ns tictactoe.main)
(use '[tictactoe.board])
(use '[tictactoe.game])
(use '[tictactoe.display])
(use '[tictactoe.humanplayer])
(use '[tictactoe.computerplayer])
(use '[tictactoe.player])

(defn -main []
  (play-game (new-board 3) display-output [{:player_type :human} {:player_type :human}]))
