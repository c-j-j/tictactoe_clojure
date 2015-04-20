(ns tictactoe.game-setup-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.game-setup :refer :all]
            ))

(facts "about game setup"
  (fact "builds player move functions"
    get-players-moves => [nil nil]))
