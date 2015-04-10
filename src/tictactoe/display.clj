(ns tictactoe.display)
(use '[tictactoe.board])

(defn print-something[board]
  (->> (partition dimension board)
      (map #(clojure.string/join " | " %))
       (clojure.string/join "\n")
       println))
