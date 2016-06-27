package org.springframework.samples.petclinic.service;

import java.util.Date;

import org.springframework.samples.petclinic.model.Appointment;

public class AppointmentSlot implements Comparable{

	private int slot;
	private Appointment appointment;
	private boolean isAvailable;

	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointment == null) ? 0 : appointment.hashCode());
		result = prime * result + (isAvailable ? 1231 : 1237);
		result = prime * result + slot;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppointmentSlot other = (AppointmentSlot) obj;
		if (appointment == null) {
			if (other.appointment != null)
				return false;
		} else if (!appointment.equals(other.appointment))
			return false;
		if (isAvailable != other.isAvailable)
			return false;
		if (slot != other.slot)
			return false;
		return true;
	}
	
	
	@Override
	public int compareTo(Object o) {
		AppointmentSlot obj= (AppointmentSlot)o;
		return this.slot - obj.slot;
	}
	
	
}
