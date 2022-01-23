package PTMusang;

import java.util.*;

public class Main {
	Scanner sc = new Scanner(System.in);
	Vector<Karyawan> data = new Vector<Karyawan>();

	public static void main(String[] args) {
		new Main();
	}

	void clear() {
		for (int x = 0; x < 30; x++)
			System.out.println("");
	}

	public int angka(int min, int max) {
		Random random = new Random();
		int angka = random.nextInt((max - min) + 1) + min;
		return angka;
	}
	
	int show() {
		int counter = 0;
		System.out.println("|----|-----------------|-----------------|-----------------|-------------|---------------|");
		System.out.printf("| %-2s | %-15s | %-15s | %-15s | %-11s |%-14s |\n", "No", "Kode Karyawan", "Nama Karyawan",
				"Jenis Kelamin", "Jabatan", "Gaji Karyawan");
		System.out.println("|----|-----------------|-----------------|-----------------|-------------|---------------|");
		
		for (int x = 0; x < data.size(); x++) {
			System.out
					.printf("| %-2s | %-15s | %-15s | %-15s | %-11s |%-14s |\n", (counter + 1) + " ", data.get(x).getKodeKaryawan() + " ", data.get(x).getName()
							+ " ", data.get(x).getGender() + " ", data.get(x).getPosition() + " ", data.get(x).getGaji() + " ");
			counter++;
		}
		return counter;
	}

	void updateKaryawan() {
		clear();
		int counter = 0;
		System.out.println("Database Karyawan");
		System.out.println("=================");
		if (data.isEmpty()) {
			System.out.println("Database Kosong!");
			System.out.println("=================");
		} else {
			counter = show();
			System.out
			.println("|----|-----------------|-----------------|-----------------|-------------|---------------|");

			int inp = 0;
			do {
				System.out.print("Input nomor urutan karyawan yang ingin diupdate: ");
				inp = sc.nextInt();
				if (inp == 0)
					break;
			} while (inp != 0 && inp > counter);

			if (inp != 0) {
				int idx = inp - 1;

				String name = data.get(idx).getName();
				String gender = data.get(idx).getGender();
				String position = data.get(idx).getPosition();
				String kodeKaryawan = data.get(idx).getKodeKaryawan();
				double gaji = data.get(idx).getGaji();

				String nameS, genderS, positionS;

				System.out.println("Input [0] to skip!");
				sc.nextLine();
				do {
					System.out.print("Input nama karyawan [>= 3]: ");
					nameS = sc.nextLine();
				} while (nameS.length() < 3 && !nameS.equals("0"));
				do {
					System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
					genderS = sc.nextLine();
				} while (!genderS.equals("Laki-laki") && !genderS.equals("Perempuan") && !genderS.equals("0"));
				do {
					System.out.print("Input position [Manager | Supervisor | Admin](Case Sensitive): ");
					positionS = sc.nextLine();
				} while (!positionS.equals("Manager") && !positionS.equals("Supervisor") && !positionS.equals("Admin") && !positionS.equals("0"));

				if (!nameS.equals("0"))
					name = nameS;
				if (!genderS.equals("0"))
					gender = genderS;
				if (!positionS.equals("0"))
					position = positionS;
				if (positionS.equals("Manager")) {
					gaji = 8000000;
				} else if (positionS.equals("Supervisor")) {
					gaji = 6000000;
				} else if (positionS.equals("Admin")){
					gaji = 4000000;
				}
				data.set(idx, new Karyawan(name, gender, position, kodeKaryawan, gaji));

				System.out.println("Berhasil mengupdate karyawan dengan id " + data.get(idx).getKodeKaryawan());
			}
		}
	}

	void viewKaryawan() {
		clear();
		int counter = 0;
		System.out.println("Database Karyawan");
		System.out.println("=================");
		if (data.isEmpty()) {
			System.out.println("Database Kosong!");
			System.out.println("=================");
		} else {
			counter = show();
			System.out
					.println("|----|-----------------|-----------------|-----------------|-------------|---------------|");
		}
	}

	void deleteKaryawan() {
		clear();
		int counter = 0;
		System.out.println("Database Karyawan");
		System.out.println("=================");
		if (data.isEmpty()) {
			System.out.println("Database Kosong!");
			System.out.println("=================");
		} else {
			counter = show();
			System.out
			.println("|----|-----------------|-----------------|-----------------|-------------|---------------|");

			int inp = 0;
			do {
				System.out.print("Input nomor urutan karyawan yang ingin dihapus: ");
				inp = sc.nextInt();

				if (inp == 0)
					break;
			} while (inp != 0 && inp > counter);

			if (inp != 0) {
				int idx = inp - 1;
					System.out.println("Karyawan dengan kode " + data.get(idx).getKodeKaryawan() + " berhasil dihapus");
					data.remove(idx);
			}
		}
	}

	void insertKaryawan() {
		clear();
		String name, gender, position, kodeKaryawan;
		double gaji;

		sc.nextLine();
		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			name = sc.nextLine();
		} while (name.length() < 3);
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gender = sc.nextLine();
		} while (!gender.equals("Laki-laki") && !gender.equals("Perempuan"));
		do {
			System.out.print("Input position [Manager | Supervisor | Admin](Case Sensitive): ");
			position = sc.nextLine();
		} while (!position.equals("Manager") && !position.equals("Supervisor") && !position.equals("Admin"));

		Random random = new Random();
		char randomizedCharacter = (char) angka(65, 90);
		char randomizedCharacter2 = (char) angka(65, 90);
		String randomNumeric = String.format("%04d", random.nextInt(10000));
		String kodeAwal = randomizedCharacter + "-" + randomNumeric;
		kodeKaryawan = randomizedCharacter2 + kodeAwal;

		if (position.equals("Manager")) {
			gaji = 8000000;
			data.add(new Karyawan(name, gender, position, kodeKaryawan, gaji));
		} else if (position.equals("Supervisor")) {
			gaji = 6000000;
			data.add(new Karyawan(name, gender, position, kodeKaryawan, gaji));
		} else {
			gaji = 4000000;
			data.add(new Karyawan(name, gender, position, kodeKaryawan, gaji));
		}
		System.out.println("Berhasil menambahkan karyawan dengan id " + kodeKaryawan);
		if (checkKaryawanPosition(position)) {
		updateGajiKaryawan(kodeKaryawan,position);
		}
		Collections.sort(data, new MySort());
	}
	
	boolean checkKaryawanPosition(String position) {
        int counter = 0;
        for(Karyawan i : data) {
            if(i.getPosition().equals(position))
            	counter++;
        }
        if(counter % 3 == 1 && counter > 3) 
        	return true;
        else 
        	return false;
    }
	
    void updateGajiKaryawan(String kodeKaryawan, String position) {
        double bonus = 0;
        double bonusManager = 0.1;
        double bonusSupervisor = 0.075;
        double bonusAdmin = 0.05;
        if(position.equals("Manager")) bonus = bonusManager;
        else if(position.equals("Supervisor")) bonus = bonusSupervisor;
        else if(position.equals("Admin")) bonus = bonusAdmin;
        
        String givenBonusKodeKaryawan = "";
        
        for(Karyawan i : data) {
            if(!i.getKodeKaryawan().equals(kodeKaryawan) && i.getPosition().equals(position)) {
                double gaji = i.getGaji();
                double total = (double) (gaji * bonus);
                i.setGaji((int)(total+gaji)); 
                givenBonusKodeKaryawan += i.getKodeKaryawan() + " ";
            }
        }
        
        System.out.printf("Bonus sebesar %.1f%%  telah diberikan kepada karyawan dengan id ", (bonus*100));
        
        String[] splitted = givenBonusKodeKaryawan.split(" ");
        int len = splitted.length; 
        
        for(int x=0;x<len;x++) {
            if(x == len-1) System.out.println(splitted[x]);
            else System.out.print(splitted[x] + ", ");
        }
    }
	
	class MySort implements Comparator<Karyawan> {

		@Override
		public int compare(Karyawan o1, Karyawan o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}

	public Main() {

		int input = 0;
		do {
			clear();
			System.out.println("Database Karyawan");
			System.out.println("=================");
			System.out.println("1. Insert Data Karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan");
			System.out.println("5. Exit");
			System.out.print(">> ");
			input = sc.nextInt();

			if (input == 1) {
				insertKaryawan();
				System.out.println("ENTER to return...");
				sc.nextLine();
			} else if (input == 2) {
				viewKaryawan();
				System.out.println("ENTER to return...");
				sc.nextLine();
				sc.nextLine();
			} else if (input == 3) {
				updateKaryawan();
				System.out.println("ENTER to return...");
				sc.nextLine();
			} else if (input == 4) {
				deleteKaryawan();
				System.out.println("ENTER to return...");
				sc.nextLine();
			}
		} while (input != 5);
	}

}
