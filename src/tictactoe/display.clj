(ns tictactoe.display)
(use '[tictactoe.board])

(def next-turn-message "%s's turn")
(def won-message "Game has been won")
(def draw-message "Game has been drawn")
(defn- board-output [board])

(defn- print-to-console [s]
  (println s))

(defn- format-board [board]
  (->> (partition dimension board)
       (map #(clojure.string/join " | " %))
       (clojure.string/join "\n")))

(defn display-output[board]
  (print-to-console (format-board board))
  (cond
    (won? board) (print-to-console won-message)
    (draw? board) (print-to-console draw-message)
    :else
    (print-to-console (format next-turn-message (current-mark board)))))

