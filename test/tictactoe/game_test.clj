(ns tictactoe.game-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.game :refer :all]
            [tictactoe.board :refer :all]))

(facts "parses int"
  (fact "parse int"
    (parse-int "0") => 0))

(unfinished print-board)

(facts "about game"
  (fact "play-turn adds move to board"
    (nth (with-in-str "1" (play-turn (new-board))) 1) => :X)

  (fact "plays game until game is over"
    (with-in-str "2" (play-game [:X :X nil :O :O nil nil nil nil] print-board))
    => [:X :X :X :O :O nil nil nil nil]
    (provided
      (print-board anything) => nil)
    )

  (fact "prints to board when game is over"
    (play-game [:X :X :X nil nil nil nil nil nil] print-board)
    => irrelevant
    (provided
      (print-board anything) => nil :times 1))

  (fact "play-turn adds move to board"
    (nth (with-in-str "1" (play-turn (new-board))) 1) => :X)
  )

(defn one-turn-game []
  (with-in-str "2" (play-game [:X :X nil :O :O nil nil nil nil] print-board)))
