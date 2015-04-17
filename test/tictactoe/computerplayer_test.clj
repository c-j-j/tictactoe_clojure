(ns tictactoe.computerplayer-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.computerplayer :refer :all]
            [tictactoe.player :as player]))

(def _ nil)

(facts "about computer player"
  ;(fact "returns 0"
    ;(negamax [nil]) => {0 10})

  (fact "returns score for terminal node"
    (let [node 0 score 10
          get-score (fn [_] score)
          terminal? (fn [_] true)
          ]
      (negamax node terminal? get-score _) => {node score}))

  (fact "negates the score of child node"
    (let [node 0 score 10 child-node 1
          get-score (fn [node] node)
          terminal? (fn [n] (not= n node))
          get-child-nodes (fn [node] [child-node])
          ]
      (negamax node terminal? get-score get-child-nodes) => [child-node -1]))

  (fact "returns the child node with the lowest(?) score"
    (let [node 0 score 10 child-node-A 2 child-node-B 1
          get-score (fn [node] node)
          terminal? (fn [n] (not= n node))
          get-child-nodes (fn [node] [child-node-A child-node-B])
          ]
      (negamax node terminal? get-score get-child-nodes) => [child-node-B -1]))
  )
