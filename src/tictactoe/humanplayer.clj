(ns tictactoe.humanplayer)

(declare get-move)
(declare parse-int)

(defn get-move []
  (parse-int (read-line)))

(defn parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)) )
