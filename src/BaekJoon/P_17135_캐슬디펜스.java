package BaekJoon;

import java.util.*;

public class P_17135_캐슬디펜스 {

	// locate 위치 저장 클래스
	static class Loc {
		int x, y;
		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, D, result;
	static int[][] map;
	static ArrayList<Loc> Enemy;
	static int[] archerLoc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();

		map = new int[N+1][M];
		Enemy = new ArrayList<>();
		archerLoc = new int[3];
		result = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					// 적 위치 저장
					Enemy.add(new Loc(i, j)); // 사람이면 추가
				}
			}
		}
		// 조합 및 답 구하기
		setArcher(0, 0);
		System.out.println(result);
	}

	static void setArcher(int start, int cnt) {
		// 조합 다 짜면
		if (cnt == 3) {
			ArrayList<Loc> archer = new ArrayList<>();
			// 궁수 추가
			for (int j = 0; j < 3; j++) {
				archer.add(new Loc(N, archerLoc[j]));
			}
			// 적 위치 저장한 리스트 복사
			ArrayList<Loc> enemy = new ArrayList<>();
			for (int i = 0; i < Enemy.size(); i++) {
				enemy.add(Enemy.get(i));
			}
			// 제거한 적 수
			int tmp = killEnemy(archer, enemy);
			// 최댓값 갱신
			result = Math.max(result, tmp);

			return;
		}
		for (int i = start; i < M; i++) {
			archerLoc[cnt] = i;
			setArcher(i + 1, cnt + 1);
		}
	}

	static int killEnemy(ArrayList<Loc> archer, ArrayList<Loc> enemy) {
		// 죽인 적의 수
		int cnt = 0;

		
		// 적이 더 없을 때까지
		while (enemy.size() != 0) {
			ArrayList<Loc> kill = new ArrayList<>();

			// 모든 궁수로 확인
			for (int i = 0; i < 3; i++) {
				int[] dis = new int[enemy.size()];
				int min = Integer.MAX_VALUE;
				ArrayList<Loc> hold = new ArrayList<>();

				// 거리 계산해서 최소 거리 구함
				for (int j = 0; j < enemy.size(); j++) {
					dis[j] = getDis(archer.get(i), enemy.get(j));
					min = Math.min(min, dis[j]);
				}

				// 최소 거리인 적 보류
				for (int j = 0; j < enemy.size(); j++) {
					if (dis[j] == min) {
						if (dis[j] <= D) {
							hold.add(enemy.get(j));
						}
					}
				}

				// 보류인 적이 하나면 죽임
				if (hold.size() == 1) {
					kill.add(hold.get(0));
				}
				// 2명 이상이면 계산해줘야함
				else if (hold.size() > 1) {
					min = Integer.MAX_VALUE;

					// 가장 왼쪽의 적부터 죽임
					for (int j = 0; j < hold.size(); j++) {
						min = Math.min(hold.get(j).y, min);
					}
					for (int j = 0; j < hold.size(); j++) {
						if (hold.get(j).y == min) {
							kill.add(hold.get(j));
						}
					}
				}
			}

			// 죽이는 리스트에 저장된 친구 판별 후 죽임
			for (int i = 0; i < kill.size(); i++) {
				for (int j = 0; j < enemy.size(); j++) {
					if (kill.get(i).x == enemy.get(j).x && kill.get(i).y == enemy.get(j).y) {
						enemy.remove(j);
						cnt++;
						break;
					}
				}
			}

			// 적들 이동
			int size = enemy.size();
			int idx = 0;
			while (size-- > 0) {
				if (enemy.get(idx).x + 1 != N) {
					enemy.add(new Loc(enemy.get(idx).x + 1, enemy.get(idx).y));
				}
				enemy.remove(idx);
			}
		}
		return cnt;
	}

	// 거리 구하기 식
	static int getDis(Loc loc1, Loc loc2) {
		return Math.abs(loc1.x - loc2.x) + Math.abs(loc1.y - loc2.y);
	}
}