/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.services;

import com.udsbr.ws.rest.controlador.calificaViajeController;
import com.udsbr.ws.rest.controlador.confUsuarioController;
import com.udsbr.ws.rest.controlador.loginController;
import com.udsbr.ws.rest.controlador.notificacionesController;
import com.udsbr.ws.rest.controlador.regVehiculoController;
import com.udsbr.ws.rest.controlador.rutasFavoritasController;
import com.udsbr.ws.rest.controlador.solicitudesConfirmadasController;
import com.udsbr.ws.rest.controlador.solicitudesPendientesController;
import com.udsbr.ws.rest.controlador.sugerenciasController;
import com.udsbr.ws.rest.controlador.validaInicioController;
import com.udsbr.ws.rest.controlador.viajesUsuariosController;
import com.udsbr.ws.rest.request.calificaViajeReq;
import com.udsbr.ws.rest.request.confUsuarioReq;
import com.udsbr.ws.rest.request.consultaViajesReq;
import com.udsbr.ws.rest.request.notificacionesReq;
import com.udsbr.ws.rest.request.regVehiculoReq;
import com.udsbr.ws.rest.request.rutasFavoritasReq;
import com.udsbr.ws.rest.request.solicitudesConfirmadasReq;
import com.udsbr.ws.rest.request.solicitudesPendientesReq;
import com.udsbr.ws.rest.request.sugerenciasReq;
import com.udsbr.ws.rest.request.validaInicioReq;
import com.udsbr.ws.rest.request.validaUsuarioReq;
import com.udsbr.ws.rest.request.viajesUsuariosReq;
import com.udsbr.ws.rest.response.calificaViajeResp;
import com.udsbr.ws.rest.response.confUsuarioResp;
import com.udsbr.ws.rest.response.consultaViajesResp;
import com.udsbr.ws.rest.response.notificacionesResp;
import com.udsbr.ws.rest.response.regVehiculoResp;
import com.udsbr.ws.rest.response.rutasFavoritasResp;
import com.udsbr.ws.rest.response.solicitudesConfirmadasResp;
import com.udsbr.ws.rest.response.solicitudesPendientesResp;
import com.udsbr.ws.rest.response.sugerenciasResp;
import com.udsbr.ws.rest.response.validaInicioResp;
import com.udsbr.ws.rest.response.validaUsuarioResp;
import com.udsbr.ws.rest.response.viajesUsuariosResp;
import java.util.concurrent.ExecutorService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;

/**
 *
 * @author MIGUEL
 */
@Path("/SobreRuedas")
public class serviciosUDSBR {

    private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();
    static Logger log = Logger.getLogger(serviciosUDSBR.class);

    /**
     *
     * @param asyncResponse
     * @param request
     */
    @POST
    @Path(value = "/validaUsuario")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void validaUsuario(@javax.ws.rs.container.Suspended final javax.ws.rs.container.AsyncResponse asyncResponse, final validaUsuarioReq request) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doValidaUsuario(request));
            }
        });
    }

    private validaUsuarioResp doValidaUsuario(validaUsuarioReq request) {
        log.info("*** Inicio Servicio validaUsuario *** " + request.getIdFacebook());
        validaUsuarioResp response = new validaUsuarioResp();
        loginController ctrl = new loginController();

        response = ctrl.validaUser(request);
        log.info("*** Fin Servicio validaUsuario ***");
        return response;
    }

    /**
     *
     * @param asyncResponse
     * @param req
     */
    @POST
    @Path(value = "/registroVehiculo")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void consultaUser(@Suspended final AsyncResponse asyncResponse, final regVehiculoReq req) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doRegVehiculo(req));
            }
        });
    }

    private regVehiculoResp doRegVehiculo(regVehiculoReq req) {
        log.info("*** Inicio Servicio registroVehiculo ***" + req.getFacebookID());
        regVehiculoResp response = new regVehiculoResp();
        regVehiculoController controlador = new regVehiculoController();
        response = controlador.consultaActualizaCreaVehiculo(req);
        log.info("*** Fin Servicio registroVehiculo ***");
        return response;
    }

    /**
     *
     * @param asyncResponse
     * @param req
     */
    @POST
    @Path(value = "/creaSugerencias")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void consultaUser(@Suspended final AsyncResponse asyncResponse, final sugerenciasReq req) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doSugerencias(req));
            }
        });
    }

    private sugerenciasResp doSugerencias(sugerenciasReq req) {
        log.info("*** Inicio Servicio doSugerencias ***" + req.getFacebookID());
        sugerenciasResp response = new sugerenciasResp();
        sugerenciasController controlador = new sugerenciasController();
        response = controlador.creaSugerencias(req);
        log.info("*** Fin Servicio doSugerencias ***");
        return response;
    }

    /**
     *
     * @param asyncResponse
     * @param req
     */
    @POST
    @Path(value = "/creaNotificacion")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void creaNotificacion(@Suspended final AsyncResponse asyncResponse, final notificacionesReq req) {
        log.info("inicio servicio notificacion");
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doCreaNotificacion(req));
            }
        });
    }

    private notificacionesResp doCreaNotificacion(notificacionesReq req) {
        log.info("*** Inicio Servicio doCreaNotificacion ***" + req.getFacebookID());
        notificacionesResp response = new notificacionesResp();
        notificacionesController controlador = new notificacionesController();
        response = controlador.creaNotificaciones(req);
        log.info("*** Fin Servicio doCreaNotificacion ***");
        return response;
    }

    /**
     *
     * @param asyncResponse
     * @param req
     */
    @POST
    @Path(value = "/consultaNotificaciones")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void consultaListaNotificacion(@Suspended final AsyncResponse asyncResponse, final notificacionesReq req) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doConsultaListaNotificacion(req));
            }
        });
    }

    private notificacionesResp doConsultaListaNotificacion(notificacionesReq req) {
        log.info("*** Inicio Servicio doConsultaListaNotificacion ***" + req.getFacebookID());
        notificacionesResp response = new notificacionesResp();
        notificacionesController controlador = new notificacionesController();
        response = controlador.ConsultaNotificacionesAll(req);
        log.info("*** Fin Servicio doConsultaListaNotificacion ***");
        return response;
    }

    /**
     *
     * @param asyncResponse
     * @param req
     */
    @POST
    @Path(value = "/consultarNotificacion")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void consultarNotificacion(@Suspended final AsyncResponse asyncResponse, final notificacionesReq req) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doConsultarNotificacion(req));
            }
        });
    }

    private notificacionesResp doConsultarNotificacion(notificacionesReq req) {
        log.info("*** Inicio Servicio doConsultarNotificacion ***" + req.getFacebookID());
        notificacionesResp response = new notificacionesResp();
        notificacionesController controlador = new notificacionesController();
        response = controlador.ConsultaNotificacion(req);
        log.info("*** Fin Servicio doConsultarNotificacion ***");
        return response;
    }

    /**
     *
     * @param asyncResponse
     * @param req
     */
    @POST
    @Path(value = "/creaActualizaConfiguracion")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void creaActualizaConf(@Suspended final AsyncResponse asyncResponse, final confUsuarioReq req) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doCreaActualizaConf(req));
            }
        });
    }

    private confUsuarioResp doCreaActualizaConf(confUsuarioReq req) {
        log.info("*** Inicio Servicio doCreaActualizaConf ***" + req.getFacebookID());
        confUsuarioResp response = new confUsuarioResp();
        confUsuarioController controlador = new confUsuarioController();
        response = controlador.creaConfiguracion(req);
        log.info("*** Fin Servicio doCreaActualizaConf ***");
        return response;
    }

    /**
     *
     * @param asyncResponse
     * @param req
     */
    @POST
    @Path(value = "/consultaConfiguracion")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void consultaConf(@Suspended final AsyncResponse asyncResponse, final confUsuarioReq req) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doConsultaConf(req));
            }
        });
    }

    private confUsuarioResp doConsultaConf(confUsuarioReq req) {
        log.info("*** Inicio Servicio doConsultaConf ***" + req.getFacebookID());
        confUsuarioResp response = new confUsuarioResp();
        confUsuarioController controlador = new confUsuarioController();
        response = controlador.consultaConfiguracion(req);
        log.info("*** Fin Servicio doConsultaConf ***");
        return response;
    }

    /**
     *
     * @param asyncResponse
     * @param req
     */
    @POST
    @Path(value = "/creaActualizaRutas")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void rutas(@Suspended final AsyncResponse asyncResponse, final rutasFavoritasReq req) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doRutasFavoritas(req));
            }
        });
    }

    private rutasFavoritasResp doRutasFavoritas(rutasFavoritasReq req) {
        log.info("*** Inicio Servicio doRutasFavoritas ***" + req.getFacebookID());
        rutasFavoritasResp response = new rutasFavoritasResp();
        rutasFavoritasController controlador = new rutasFavoritasController();
        response = controlador.crudRutasFavoritas(req);
        log.info("*** Fin Servicio doRutasFavoritas ***");
        return response;
    }

    /**
     *
     * @param asyncResponse
     * @param req
     */
    @POST
    @Path(value = "/consultaCalificaViaje")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void calificaViaje(@Suspended final AsyncResponse asyncResponse, final calificaViajeReq req) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doCalificaViaje(req));
            }
        });
    }

    private calificaViajeResp doCalificaViaje(calificaViajeReq req) {
        log.info("*** Inicio Servicio doCalificaViaje ***" + req.getFacebookID());
        calificaViajeResp response = new calificaViajeResp();
        calificaViajeController controlador = new calificaViajeController();
        response = controlador.creaConsulta(req);
        log.info("*** Fin Servicio doCalificaViaje ***");
        return response;
    }

    /**
     *
     * @param asyncResponse
     * @param req
     */
    @POST
    @Path(value = "/solicitudesPendientes")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void solicitudes(@Suspended final AsyncResponse asyncResponse, final solicitudesPendientesReq req) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doSolicitudesPendientes(req));
            }
        });
    }

    private solicitudesPendientesResp doSolicitudesPendientes(solicitudesPendientesReq req) {
        log.info("*** Inicio Servicio doSolicitudesPendientes ***" + req.getFacebookID());
        solicitudesPendientesResp response = new solicitudesPendientesResp();
        solicitudesPendientesController controlador = new solicitudesPendientesController();
        response = controlador.solicitudesPend(req);
        log.info("*** Fin Servicio doSolicitudesPendientes ***");
        return response;
    }

    /**
     *
     * @param asyncResponse
     * @param req
     */
    @POST
    @Path(value = "/solicitudesConfirmadas")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void solicitudes(@Suspended final AsyncResponse asyncResponse, final solicitudesConfirmadasReq req) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doSolicitudesConfirmadas(req));
            }
        });
    }

    private solicitudesConfirmadasResp doSolicitudesConfirmadas(solicitudesConfirmadasReq req) {
        log.info("*** Inicio Servicio doSolicitudesConfirmadas ***" + req.getFacebookID());
        solicitudesConfirmadasResp response = new solicitudesConfirmadasResp();
        solicitudesConfirmadasController controlador = new solicitudesConfirmadasController();
        response = controlador.solicitudesConf(req);
        log.info("*** Fin Servicio doSolicitudesConfirmadas ***");
        return response;
    }
    
    /**
     *
     * @param asyncResponse
     * @param req
     */
    @POST
    @Path(value = "/consultaCreaActualizaViaje")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void consultaCreaActualizaViaje(@Suspended final AsyncResponse asyncResponse, final viajesUsuariosReq req) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doConsultaActualizaViaje(req));
            }
        });
    }

    private viajesUsuariosResp doConsultaActualizaViaje(viajesUsuariosReq req) {
        log.info("*** Inicio Servicio doConsultaActualizaViaje ***" + req.getFacebookID());
        viajesUsuariosResp response = new viajesUsuariosResp();
        viajesUsuariosController controlador = new viajesUsuariosController();
        response = controlador.creaActualizaViaje(req);
        log.info("*** Fin Servicio doConsultaActualizaViaje ***");
        return response;
    }
    
    /**
     *
     * @param asyncResponse
     * @param req
     */
    @POST
    @Path(value = "/consultaViajes")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void consultaViajes (@Suspended final AsyncResponse asyncResponse, final consultaViajesReq req) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doConsultaViajes(req));
            }
        });
    }

    private consultaViajesResp doConsultaViajes(consultaViajesReq req) {
        log.info("*** Inicio Servicio doConsultaViajes ***" + req.getFacebookID());
        consultaViajesResp response = new consultaViajesResp();
        viajesUsuariosController controlador = new viajesUsuariosController();
        response = controlador.viajesUsuarios(req);
        log.info("*** Fin Servicio doConsultaViajes ***");
        return response;
    }
    
     /**
     *
     * @param asyncResponse
     * @param req
     */
    @POST
    @Path(value = "/inicioSesion")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void inicioSesion (@Suspended final AsyncResponse asyncResponse, final validaInicioReq req) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doInicioSesion(req));
            }
        });
    }

    private validaInicioResp doInicioSesion(validaInicioReq req) {
        log.info("*** Inicio Servicio doInicioSesion ***" + req.getFacebookID());
        validaInicioResp response = new validaInicioResp();
        validaInicioController controlador = new validaInicioController();
        response = controlador.validaSesionCtrl(req);
        log.info("*** Fin Servicio doInicioSesion ***");
        return response;
    }
}
