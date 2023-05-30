import { Housing } from "../enum/housing.enum";

export interface Customer {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    phoneNumber: string;
    age: number;
    housing: Housing;
}