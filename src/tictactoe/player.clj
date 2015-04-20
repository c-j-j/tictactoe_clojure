(ns tictactoe.player)

(defmulti get-move (fn [player-types board]
                         (player-types :player_type)))

(defn player-move[player]
  (fn [board] (get-move player board)))
