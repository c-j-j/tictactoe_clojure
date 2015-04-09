(ns tictactoe.board)

(def dimension 3)

(def new-board (apply vector (repeat (square dimension) nil)))

(def any? (comp boolean some))

(defn add-move [board position mark]
  (assoc board position mark))

(defn- line-won? [board indices]
  (let [line (map #(nth board %) indices)]
    (all-elements-equal line)))

(defn won? [board]
  (if (every? nil? board)
    false
    (any? true? (map #(line-won? board %) [[0 1 2], [3 4 5], [6 7 8]]))
    ))

(defn- square[num](* num num))

(defn- all-elements-equal[line]
  (and (apply = line) (not-every? nil? line)))
