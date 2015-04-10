(ns tictactoe.game-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.game :refer :all]
            [tictactoe.board :refer :all]))

(facts "parses int"
  (fact "parse int"
    (parse-int "0") => 0))

(facts "about game"
  (fact "play turn adds move to board"
    (nth (with-in-str "1" (play new-board)) 1) => :X)

  (fact "plays game until game is over"
   (with-in-str "2" (play-game [:X :X nil :O :O nil nil nil nil]) => [:X :X :X :O :O nil nil nil nil]))
  )
