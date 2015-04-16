(ns tictactoe.player)

(defmulti get-move-new (fn [player-types board]
                         (player-types :player_type)))

(defn player-move[player]
  (fn [board] (get-move-new player board)))
