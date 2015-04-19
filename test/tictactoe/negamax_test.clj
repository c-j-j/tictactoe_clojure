(ns tictactoe.negamax-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.negamax :refer :all]))

(def _ nil)

(facts "about negamax"
  (fact "returns score for terminal node"
    (let [node 0 score 10
          get-score (fn [_] score)
          terminal? (fn [_] true)
          ]
      (negamax node terminal? get-score _ 0) => 10))

  (fact "negates the score of child node"
    (let [node 0 score 10 child-node 1
          get-score (fn [node] node)
          terminal? (fn [n] (not= n node))
          get-child-nodes (fn [node] [child-node])]
      (negamax node terminal? get-score get-child-nodes 0) => child-node))

  (fact "returns the child node with the lowest score"
    (let [node 0 score 10 child-node-A 2 child-node-B 1
          get-score (fn [node] node)
          terminal? (fn [n] (not= n node))
          get-child-nodes (fn [node] [child-node-A child-node-B])
          ]
      (negamax node terminal? get-score get-child-nodes 0) => child-node-B))


  ;    0
  ; 1     2
  ;2 3   4 5
  (fact "returns the child node, not grand child"
    (let [node 0
          get-score (fn [n] n)
          terminal? (fn [n] (>= n 4))
          get-child-nodes (fn [n] [(+ 1 n) (+ 2 n)])
          ]
      (negamax node terminal? get-score get-child-nodes 0) => 2))


  (fact "returns the child node vector with the lowest score"
    (let [node 0 score 10 child-node-A [:a] child-node-B [:b :a]
          get-score (fn [node] (count node))
          terminal? (fn [n] (not= n node))
          get-child-nodes (fn [node] [child-node-A child-node-B])
          ]
      (negamax node terminal? get-score get-child-nodes 0) => child-node-A))
  )
