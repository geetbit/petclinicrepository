package org.springframework.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Appointment;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pets;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.AppointmentService;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppointmentController {

	private final ClinicService clinicService;
	private AppointmentService as;

	@Autowired
	public AppointmentController(ClinicService clinicService, AppointmentService aptService) {
		this.clinicService = clinicService;
		as = aptService;
	}

	@RequestMapping(value = "/appointment", method = RequestMethod.GET)
	public Map<String, Object> returnOwnerAndVet(Map<String, Object> model) {
		// TODO: Call appopriate service layer
	    model.put("ownerList", this.clinicService.findOwners());
		Vets vets = new Vets();
		vets.getVetList().addAll(this.clinicService.findVets());
		model.put("vetList", vets);

		return model;

	}

	@RequestMapping(value = "/appointment", method = RequestMethod.POST)
	public String createAppointment(@Valid Appointment apt, BindingResult result, Map<String, Object> model, Vet vet) {
		// TODO: Call appropriate Service Layer
		// model.addAttribute("availableAppointments",
		// clinicService.getAvailableAppointment(vet));
		as.createAppointment(apt);
		return null;

	}

	@RequestMapping("/owners/{ownerId}/pet")
	public @ResponseBody Pets showResourcesPetList(@PathVariable("ownerId") int ownerId) {
		Pets pets = new Pets();
		// TODO: Call Service Layer
		//pets.getPetList().addAll(this.clinicService.findPets(ownerId));
		
		return pets;
	}

	@RequestMapping("/vets/{vetId}/appointment")
	public @ResponseBody Appointment showResourcesAppointmentList(@PathVariable("vetId") int vetId) {
		Appointment appointments = new Appointment();
		// TODO: Call Service Layer
		//appointments.getAppointmentList().addAll(this.clinicService.findAppointment(vetId));
		
		return appointments;
	}
	
	
}
