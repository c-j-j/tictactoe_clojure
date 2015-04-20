(ns tictactoe.computerplayer
  (require [tictactoe.player :as player]
           [tictactoe.game :refer :all]
           [tictactoe.board :refer :all]
          [tictactoe.negamax :refer :all]))

(defn- find-differences [arr1 arr2]
  (filter #(not= (get arr1 %) (get arr2 %)) (range (count arr1))))

(defmethod player/get-move-new :computer [_ board]
  (let [best-possible-board (negamax board game-over? get-score next-board-states)
       board-differences (find-differences board best-possible-board)]
    (first board-differences)))
