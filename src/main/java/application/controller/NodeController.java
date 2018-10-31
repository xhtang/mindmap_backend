package application.controller;

import application.entity.CurrentUser;
import application.entity.Node;
import application.entity.view.NodeAttachments;
import application.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class NodeController {
    private final NodeService nodeService;

    @Autowired
    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @RequestMapping(value = "/api/node/getAll/{mindMapId}", method = RequestMethod.GET)
    public @ResponseBody Node getAllNodesByMindMapId(
            @PathVariable String mindMapId,
            Principal principal) {
   return nodeService.getAll(Long.parseLong(mindMapId));

    }

    @RequestMapping(value = "/api/node/attachments/{nodeId}", method = RequestMethod.GET)
    public @ResponseBody NodeAttachments getAttachments(@PathVariable String nodeId) {
        return nodeService.getAttachments(Long.parseLong(nodeId));
    }
}
