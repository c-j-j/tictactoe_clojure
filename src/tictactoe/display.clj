(ns tictactoe.display)
(use '[tictactoe.board])

(def next-turn-message "%s's turn")
(def won-message "Game has been won")
(def draw-message "Game has been drawn")
(defn- board-output [board])

(defn- print-to-console [s]
  (println s))

;TODO find a way to not use macro threading here
(defn- format-board [board]
  (->>
    (map #(if(= %1 nil) %2 (name %1)) board (range (count board)))
    (partition (dimension board))
    (map #(clojure.string/join " | " %))
    (clojure.string/join "\n")))

(defn display-output[board]
  (print-to-console (format-board board))
  (cond
    (won? board) (print-to-console won-message)
    (draw? board) (print-to-console draw-message)
    :else
    (print-to-console (format next-turn-message (name (current-mark board))))))

(defn- parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)) )

(defn- is-integer? [s]
  (boolean (re-matches #"\d+" s)))

(defn read-integer []
  (loop [input (read-line)]
    (if (is-integer? input)
      (parse-int input)
      (read-integer))))

(defn get-option-from-user [message options]
  (print-to-console message)
  (doall (for [option-index (range 1 (inc (count options)))]
    (print-to-console (format "%d: %s" option-index (get (nth options (dec option-index)) :description)))
    ))

  (let [selected-option (read-integer)]
    (if (<= selected-option (count options))
      (get (nth options (dec selected-option)) :option)
      (get-option-from-user message options))
    ))
