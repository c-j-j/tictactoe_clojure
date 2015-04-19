(ns tictactoe.negamax)

(defn- update-values [m f]
  (reduce (fn [result [k v]](assoc result k (f v))) {} m)
  )

(defn- sort-map-by-value [m]
  (into (sorted-map-by (fn [key1 key2] (compare [(get m key2) key2] [(get m key1) key1]))) m))

(defn negate-all [coll]
  (map #(unchecked-negate %) coll)
  )

(defn negamax[node terminal? get-score get-child-nodes depth]
  (if (terminal? node)
    (get-score node)
    (let [apply-negamax #(negamax % terminal? get-score get-child-nodes (inc depth))
          child-nodes (get-child-nodes node)
          child-scores (map apply-negamax child-nodes)
          negated-scores (negate-all child-scores)
          child-node-scores (apply hash-map (interleave child-nodes negated-scores))
          best-score (sort-map-by-value child-node-scores)]
      (if (= depth 0)
        (first (keys best-score))
        (first (vals best-score))))
    )
  )

