(ns tictactoe.board)

(defn dimension[board]
  (int (Math/sqrt (count board))))

(defn new-board
  ([] (new-board 3))
  ([dim] (letfn [(square [x](* x x))]
           (apply vector (repeat (square dim) nil)))))

(defn empty-positions [board]
  (filter identity (map-indexed (fn[index item](if (nil? item)index)) board))
  )

(defn number-of-moves-made[board]
  (count (filter identity board)))

(defn player-ones-turn? [board]
  (even? (number-of-moves-made board)))

(defn current-mark [board]
  (if (player-ones-turn? board) :X :O))

(defn add-move [board position]
  (assoc board position (current-mark board))
  )

(defn next-board-states [board]
  (map #(add-move board %) (empty-positions board)))

(def any? (comp boolean some))

(defn- rows[board]
  (partition (dimension board) board))

(defn- cols[board]
  (apply map vector (rows board)))

(defn- diagonal-line[board step-size drop-number]
  (vector (drop drop-number (reverse (drop drop-number (take-nth step-size board))))))

(defn- diagonal-top-left[board]
  (diagonal-line board (inc (dimension board)) 0))

(defn- diagonal-top-right[board]
  (diagonal-line board (dec (dimension board)) 1))

(defn- diagonals[board]
  (concat (diagonal-top-left board) (diagonal-top-right board)))

(defn- lines[board]
  (concat (rows board) (cols board) (diagonals board)))

(defn won? [board]
  (letfn [(line-won? [line] (and (apply = line) (not-every? nil? line)))]
    (any? true? (map #(line-won? %) (lines board)))))

(defn draw? [board]
  (letfn [(board-full? [board] (every? (comp not nil?) board))]
    (and (board-full? board) ((comp not won?) board))))
