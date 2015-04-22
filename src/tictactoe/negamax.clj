(ns tictactoe.negamax)

(defn- sort-map-by-value [m]
  (into (sorted-map-by (fn [key1 key2] (compare [(get m key2) key2] [(get m key1) key1]))) m))

(def maximum-depth 6)

(defn- alpha-beta-prune [alpha beta child-nodes negamax-f]
  (reduce (fn[scores-so-far next-node]
            (let [alpha (apply max scores-so-far)]
              (if (< alpha beta)
                (conj scores-so-far (negamax-f next-node alpha))
                scores-so-far))) [alpha] child-nodes))

(defn- get-best-node[node terminal? get-score get-child-nodes depth alpha beta]
  (if (or (= depth maximum-depth) (terminal? node))
    (get-score node)
    (let [get-best-child-node (fn[child-node alpha]
                          (- (get-best-node child-node terminal? get-score get-child-nodes (inc depth) (- beta) (- alpha))))
          child-nodes (get-child-nodes node)
          child-scores (alpha-beta-prune alpha beta child-nodes get-best-child-node)
          child-node-scores (zipmap child-nodes (rest child-scores))
          best-score (sort-map-by-value child-node-scores)]
      (if (= depth 0)
        (first (keys best-score))
        (first (vals best-score)))))
  )

(defn negamax[node terminal? get-score get-child-nodes]
  (let [terminal? (memoize terminal?)
        get-score (memoize get-score)
        get-child-nodes (memoize get-child-nodes)]
    (get-best-node node terminal? get-score get-child-nodes 0, -1000, 1000)))

