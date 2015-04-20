(ns tictactoe.game-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [tictactoe.game :refer :all]
            [tictactoe.player :as player]
            [tictactoe.board :refer :all]))

(unfinished display-output)
(unfinished player-1-move)

(defn next-player-move [player_type x]
  (defmethod player/get-move-new player_type [_ board] x))

(def stub-player-one {:player_type :stub-player-one})
(def stub-player-two {:player_type :stub-player-two})
(def stub-players [stub-player-one stub-player-two])

(facts "about game"
  (fact "adds player one move to board"
    (do (next-player-move :stub-player-one 1) (nth (play-turn (new-board) stub-players) 1)) => :X)

  (fact "adds player two move to board"
    (do (next-player-move :stub-player-two 3)
        (nth (play-turn [:X nil nil nil nil nil nil nil nil] stub-players) 3)) => :O)

  (fact "plays game until game is over"
    (do (next-player-move :stub-player-one 2)
        (play-game [:X :X nil :O :O nil nil nil nil] display-output stub-players)) => [:X :X :X :O :O nil nil nil nil]
    (provided (display-output anything) => nil))

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
