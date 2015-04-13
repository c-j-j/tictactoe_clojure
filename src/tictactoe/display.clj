(ns tictactoe.display)
(use '[tictactoe.board])

(defn print-board[board]
  (->> (partition dimension board)
       (map #(clojure.string/join " | " %))
       (clojure.string/join "\n")
       println))
