(ns tictactoe.computerplayer
  (require [tictactoe.player :as player]))


(defn- update-values [m f & args]
  (reduce (fn [r [k v]] (assoc r k (apply f v args))) {} m)
  )

(defn negamax[node terminal? get-score get-child-nodes]
  (if (terminal? node)
    {node (get-score node)}
    (let [child-scores (map #(negamax % terminal? get-score get-child-nodes) (get-child-nodes node))
          negated-scores (map #(update-values % unchecked-negate) child-scores)
          ]
      (first negated-scores)
      )
    )
  )

(defmethod player/get-move-new :computer [_ board]
  prn "in computer player"
  )
