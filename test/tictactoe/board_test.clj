(ns tictactoe.board-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.board :refer :all]))


(defn create-board []
  (add-move (add-move new-board 0 :X) 1 :X)
  )

(facts "about board"
  (fact "creates new board"
    (count new-board) => 9)
  (fact "adds move to board"
    (add-move new-board 0 :X) => (concat [:X] (repeat 8 nil))
    (nth (add-move new-board 1 :X) 1) => :X)
  (fact "winner occupies row"
    (won? new-board) => false
    (won?
      [:X :X :X
       nil nil nil
       nil nil nil]) => true
    (won?
      [nil nil nil
       :X :X :X
       nil nil nil]) => true
    (won?
      [nil nil nil
       nil nil nil
       :X :X :X]) => true
    )
  )
