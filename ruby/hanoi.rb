require 'set'
class Hanoi
  OPTIONS = ['0','1','2']
  def self.dfs_solve(state, goal, length)
    @state_set = Set.new([state]) unless @state_set 

    puts state

    if state.eql?(goal)
      @state_set = nil
      return true
    end
    
    (0...length).each do |i|
    	(0...3).each do |t|
        unless state[0..i].include?(OPTIONS[t]) 
          new_state = String.new(state)
          new_state[i] = OPTIONS[t]
          unless @state_set.include?(new_state)
            @state_set << new_state
            return dfs_solve(new_state, goal, length)
          end
        end
      end
    end
  end

  def self.bfs_solve(state, goal, length)
    @state_set = Set.new([state]) unless @state_set 

    puts state

    if state.eql?(goal)
      @state_set = nil
      return true
    end

    

  end
end

Hanoi.dfs_solve('000', '222', 3)
