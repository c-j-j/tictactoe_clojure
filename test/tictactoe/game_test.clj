(ns tictactoe.game-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.game :refer :all]
            [tictactoe.board :refer :all]))

(unfinished print-board)
(unfinished player-1-move)

(facts "about game"
  (fact "play-turn adds move to board"
    (nth (play-turn (new-board) player-1-move) 1) => :X
    (provided (player-1-move anything) => 1))

  (fact "plays game until game is over"
    (play-game [:X :X nil :O :O nil nil nil nil] print-board player-1-move)
    => [:X :X :X :O :O nil nil nil nil]
    (provided
      (player-1-move anything) => 2
      (print-board anything) => nil))

  (fact "prints to board when game is over"
    (play-game [:X :X :X nil nil nil nil nil nil] print-board nil)
    => irrelevant
    (provided
      (print-board anything) => nil :times 1))
  )

(defn one-turn-game []
  (with-in-str "2" (play-game [:X :X nil :O :O nil nil nil nil] print-board)))
