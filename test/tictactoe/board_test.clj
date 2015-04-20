(ns tictactoe.board-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.board :refer :all]))

(facts "about board"
  (fact "creates new board"
    (count (new-board)) => 9)

  (fact "adds move to board"
    (add-move (new-board) 0) => (concat [:X] (repeat 8 nil))
    (nth (add-move (new-board) 1) 1) => :X)
  (fact "adds O as second move"
    (add-move [:X :O :X nil nil nil nil nil nil] 7) => [:X :O :X nil nil nil nil :O nil])
  (fact "winner occupies row"
    (won? (new-board)) => false
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
    (won?
      [:X nil nil
       :X nil nil
       :X nil nil]) => true
    (won?
      [nil :X nil
       nil :X nil
       nil :X nil]) => true
    (won?
      [nil nil :X
       nil nil :X
       nil nil :X]) => true
    (won?
      [:X nil nil
       nil :X nil
       nil nil :X]) => true
    (won?
      [nil nil :X
       nil :X nil
       :X nil nil]) => true
    (won?
      [nil nil :X
       nil :X nil
       nil nil nil]) => false
    )
  (fact "full board with no winner is a draw"
    (draw?
      [nil nil nil
       nil nil nil
       nil nil nil]) => false
    (draw?
      [:X :O :X
       :X :X :O
       :O :X :O]) => true
    (draw?
      [:X :O :X
       :X :X :O
       :X :X :O]) => false
    )

  (fact "determines empty positions"
    (empty-positions
      [:X :X :O
       :X :O :O
       :O nil nil]) => (contains 7 8)
    )

  (fact "next possible board states"
    (next-board-states
      [:X :X :O
       :X :O :O
       :O :X nil]) =>

    (contains
      '([:X :X :O
         :X :O :O
         :O :X :X])
      )
    )
  )
