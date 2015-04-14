(ns tictactoe.display)
(use '[tictactoe.board])

(defn display-output[board]
  (->> (partition dimension board)
       (map #(clojure.string/join " | " %))
       (clojure.string/join "\n")
       println))
