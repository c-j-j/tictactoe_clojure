(ns tictactoe.humanplayer-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.humanplayer :refer :all]))

(facts "about humanplayer"
  (fact "gets user input from console"
    (with-in-str "1" (get-move)) => 1))
