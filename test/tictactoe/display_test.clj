(ns tictactoe.display-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.display :refer :all]
            [tictactoe.board :refer :all]
            ))

(facts "about board"
  (fact "prints board to display"
    (with-out-str (print-something [:A :B :C :D :E :F] ))
    => ":A | :B | :C\n:D | :E | :F\n")
  )
