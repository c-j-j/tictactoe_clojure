(ns tictactoe.computerplayer
  (require [tictactoe.player :as player]))


(defn- update-values [m f]
  (reduce (fn [result [k v]] (assoc result k (f v))) {} m)
  )

(defn- sort-map-by-value [m]
  (into (sorted-map-by (fn [key1 key2] (compare [(get m key2) key2] [(get m key1) key1]))) m)
  )

(defn negamax[node terminal? get-score get-child-nodes]
  (if (terminal? node)
    {node (get-score node)}
    (let [apply-negamax #(negamax % terminal? get-score get-child-nodes)
          child-scores (apply merge (map apply-negamax (get-child-nodes node)))
          negated-scores (update-values child-scores unchecked-negate)]
      (first (sort-map-by-value negated-scores)))
    )
  )

(defmethod player/get-move-new :computer [_ board]
  prn "in computer player"
  )
