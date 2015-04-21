(ns tictactoe.computerplayer-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.computerplayer :refer :all]
            [tictactoe.board :refer :all]
            [tictactoe.player :as player]))

(defn get-computer-move[board]
  (player/get-move {:player_type :computer} board))

(facts "about computer player"
  (fact "goes in last possible space"
    (get-computer-move [:X :X :O
                        :O :O :X
                        :X nil :X]) => 7)

  (fact "goes in one of last possible spaces"
    (get-computer-move [:X :X :O
                        :O :O :X
                        :X nil nil]) => 7)

  ;needs optimising
  (fact "chooses corner to start things of with"
    (get-computer-move (new-board)) => 0)

  ;(fact "chooses centre when opponent starts in corner"
  (get-computer-move [:X nil nil
                      nil nil nil
                      nil nil nil]) => 4

  (fact "blocks opponent from winning"
    (get-computer-move [:X nil nil
                        nil :O nil
                        :X nil nil]) => 3)

  (fact "creates fork"
    (get-computer-move [:X :O nil
                        nil :X nil
                        nil nil :O]) => 3)

  (fact "creates another fork"
    (get-computer-move [:X :O :X
                        nil :X nil
                        nil nil :O]) => 6)
  )
