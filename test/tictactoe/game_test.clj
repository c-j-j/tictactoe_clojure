(ns tictactoe.game-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.game :refer :all]
            [tictactoe.board :refer :all]))

(unfinished display-output)
(unfinished player-1-move)

(facts "about game"
  (fact "play-turn adds move to board"
    (nth (play-turn (new-board) player-1-move) 1) => :X
    (provided (player-1-move anything) => 1))

  (fact "plays game until game is over"
    (play-game [:X :X nil :O :O nil nil nil nil] display-output player-1-move)
    => [:X :X :X :O :O nil nil nil nil]
    (provided
      (player-1-move anything) => 2
      (display-output anything) => nil))

  (fact "prints to board when game is over"
    (play-game [:X :X :X nil nil nil nil nil nil] display-output nil)
    => irrelevant
    (provided
      (display-output anything) => nil :times 1))

  (fact "score is -10 when game has been won"
    (get-score [:X :X :X nil nil nil nil nil nil]) => -10)

  (fact "score is 0 when game has been drawn"
    (get-score [:X :X :O :O :X :X :X :O :O]) => 0)
  )

(defn one-turn-game []
  (with-in-str "2" (play-game [:X :X nil :O :O nil nil nil nil] display-output)))
