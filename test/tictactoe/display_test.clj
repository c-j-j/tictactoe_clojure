(ns tictactoe.display-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.display :refer :all]
            [tictactoe.board :refer :all]
            ))

(facts "about display output"
  (fact "prints board to display"
    (with-out-str (display-output [:A :B :C :D :E :F :G :H :I] ))
    => (contains "A | B | C\nD | E | F\n")

    (with-out-str (display-output (new-board 3) ))
    => (contains "0 | 1 | 2\n3 | 4 | 5\n"))

  (fact "prints winning status"
    (with-out-str (display-output [:X :X :X nil nil nil nil nil nil]))
    => (contains won-message))

  (fact "prints next player"
    (with-out-str (display-output (new-board)))
    => (contains (format next-turn-message (name (current-mark (new-board))))))

  (fact "prints draw message"
    (with-out-str (display-output [:X :X :O :O :X :X :X :O :O]))
    => (contains draw-message))

  (fact "gets option from user"
   (with-in-str "1" (get-option-from-user "message" [{:option :some-option :description ""}])) => :some-option)

  (fact "ignores invalid option from user"
   (with-in-str "2\n1" (get-option-from-user "message" [{:option :some-option :description ""}])) => :some-option)
)

(facts "about input"
 (fact "integer input"
    (with-in-str "1" (read-integer)) => 1)

 (fact "ignores non-integer input"
    (with-in-str "A\n1" (read-integer)) => 1)
  )
