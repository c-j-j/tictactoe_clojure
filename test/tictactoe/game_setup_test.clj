(ns tictactoe.game-setup-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.board :refer :all]
            [tictactoe.game-setup :refer :all]
            ))

(unfinished get-option-from-user)

(facts "about game setup"
  (fact "setup board"
    (setup-board get-option-from-user) => (new-board 3)
    (provided (get-option-from-user anything anything) => 3))

  (fact "setup player 1"
    (first (setup-players get-option-from-user)) => (contains {:player_type :human})
    (provided
      (get-option-from-user anything anything) => :human)
    )

  (fact "setup player 2"
    (second (setup-players get-option-from-user)) => (contains {:player_type :computer})
    (provided
      (get-option-from-user anything anything) => :computer)
    )
  )
