(ns tictactoe.humanplayer)

(declare get-move)
(declare parse-int)
(declare move-available?)
(declare is-integer?)
(declare get-input)
(declare move-valid?)
(declare move-in-range?)
(declare get-valid-move)

(defn get-move [board]
  (parse-int (get-valid-move board)))

(defn get-valid-move [board]
  (loop [user-move (get-input)]
   (if(move-valid? user-move board)
     user-move
     (recur (get-valid-move board))))
  )

(defn get-input [] (read-line))

(defn move-valid? [move board]
  (if (and
        (is-integer? move)
        (move-available? board (parse-int move))
        (move-in-range? board (parse-int move))) true false))

(defn is-integer? [s]
  (boolean (re-matches #"\d+" s)))

(defn move-available? [board move]
  (nil? (get board move)))

(defn move-in-range? [board move]
  (> (count board) move))

(defn parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)) )
