(ns tictactoe.humanplayer
  (:require [tictactoe.player :as player]
            [tictactoe.display :as display]
            ))

(defn- get-input [] (display/read-integer))

(defn- move-available? [board move]
  (nil? (get board move)))

(defn- move-in-range? [board move]
  (> (count board) move))

(defn- move-valid? [move board]
  (and (move-available? board move) (move-in-range? board move)))

(defn- get-valid-move [board]
  (loop [user-move (get-input)]
    (if(move-valid? user-move board)
      user-move
      (recur (get-valid-move board))))
  )

(defmethod player/get-move :human [_ board]
  (get-valid-move board))
