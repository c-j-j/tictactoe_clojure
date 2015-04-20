(ns tictactoe.player)

(defmulti get-move (fn [player-types board]
                         (player-types :player_type)))
