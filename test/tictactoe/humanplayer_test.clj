(ns tictactoe.humanplayer-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.humanplayer :refer :all]))

(facts "about humanplayer"
  (fact "gets user input from console"
    (with-in-str "1" (get-move [0])) => 1)

  (fact "does not return non-integer input"
    (with-in-str "a\n0" (get-move [nil])) => 0
    (with-in-str "b\n0" (get-move [nil])) => 0)

  (fact "move not valid when move exists"
    (with-in-str "0\n1" (get-move [:X nil])) => 1)
  )
