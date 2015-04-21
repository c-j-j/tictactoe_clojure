(ns tictactoe.negamax)

(defn- sort-map-by-value [m]
  (into (sorted-map-by (fn [key1 key2] (compare [(get m key2) key2] [(get m key1) key1]))) m))

(def maximum-depth 6)

(defn negamax([node terminal? get-score get-child-nodes]
              (negamax node terminal? get-score get-child-nodes 0))
  ([node terminal? get-score get-child-nodes depth]
   (if (or (= depth maximum-depth) (terminal? node))
     (get-score node)
     (let [apply-negamax #(-(negamax % terminal? get-score get-child-nodes (inc depth)))
           child-nodes (get-child-nodes node)
           child-scores (map apply-negamax child-nodes)
           child-node-scores (zipmap child-nodes child-scores)
           best-score (sort-map-by-value child-node-scores)]
       (if (= depth 0)
         (first (keys best-score))
         (first (vals best-score))))
     ))
  )

