import {RegisterUserData} from "./register-user-data";

export interface WorkerData {
  pesel: string,
  registerUserData: RegisterUserData,
  hourlyRate: number,
  roles: string[]
}
