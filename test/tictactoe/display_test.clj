(ns tictactoe.display-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.display :refer :all]
            [tictactoe.board :refer :all]
            ))

(facts "about board"
  (fact "prints board to display"
    (with-out-str (display-output [:A :B :C :D :E :F] ))
    => (contains "A | B | C\nD | E | F\n")
    (with-out-str (display-output [nil nil nil nil nil nil] ))
    => (contains "0 | 1 | 2\n3 | 4 | 5\n")
    )
  (fact "prints winning status"
    (with-out-str (display-output [:X :X :X]))
    => (contains won-message)
    )
  (fact "prints next player"
    (with-out-str (display-output (new-board)))
    => (contains (format next-turn-message (name (current-mark (new-board))))))
  (fact "prints draw message"
    (with-out-str (display-output [:X :X :O :O :X :X :X :O :O]))
    => (contains draw-message))
  )
