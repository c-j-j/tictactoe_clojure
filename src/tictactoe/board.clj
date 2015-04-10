(ns tictactoe.board)

(def dimension 3)

(declare board-full?)

(def new-board (apply vector (repeat (square dimension) nil)))

(def any? (comp boolean some))

(defn add-move [board position]
  (->> (filter identity board)
       count
       (#(if (even? %) :X :O))
       (assoc board position))
  )

(defn won? [board]
  (any? true? (map #(line-won? %) (lines board))))

(defn draw? [board]
  (and (board-full? board) ((comp not won?) board))
  )

(defn- board-full? [board]
  (every? (comp not nil?) board)
  )

(defn- line-won? [line]
  (and (all-elements-equal line) (not-every? nil? line)))

(defn- lines[board]
  (concat (rows board) (cols board) (diagonals board)))

(defn- rows[board]
  (partition dimension board))

(defn- cols[board]
  (apply map vector (rows board)))

(defn- diagonals[board]
  (concat (diagonal-top-left board) (diagonal-top-right board)))

(defn- diagonal-top-left[board]
  (diagonal-line board (inc dimension) 0))

(defn- diagonal-top-right[board]
  (diagonal-line board (dec dimension) 1))

(defn- diagonal-line[board step-size drop-number]
  (vector (drop drop-number (reverse (drop drop-number (take-nth step-size board))))))

(defn- square[num](* num num))

(defn- all-elements-equal[line]
  (and (apply = line)))
